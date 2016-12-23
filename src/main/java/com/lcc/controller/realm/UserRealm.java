package com.lcc.controller.realm;

import com.lcc.bean.Result;
import com.lcc.bean.entity.*;
import com.lcc.biz.UserBiz;
import com.lcc.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * Created by lcc on 2016/12/23.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserBiz biz;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        HashSet<String> roleSet = new HashSet<String>();
        HashSet<String> permissionSet = new HashSet<String>();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String userno = (String) principals.getPrimaryPrincipal();
        Result<RcUser> result = biz.getUser(userno);

        if (result.isStatus()) {
            long userId = result.getResultData().getId();
            Result<List<RcUserRole>> resultUR = biz.getUserRole(userId);
            if (resultUR.isStatus()) {
                // 获取角色
                List<RcUserRole> urList = resultUR.getResultData();
                for (RcUserRole rcUserRole : urList) {
                    Result<RcRole> resultR = biz.getRole(rcUserRole.getRolesId());
                    if (resultR.isStatus()) {
                        roleSet.add(resultR.getResultData().getRoleValue());
                    }

                    // 获取权限
                    Result<List<RcRolePermissions>> resultRP = biz.getRolePermissions(rcUserRole.getRolesId());
                    if (resultRP.isStatus()) {
                        List<RcRolePermissions> rpList = resultRP.getResultData();
                        for (RcRolePermissions rcRolePermissions : rpList) {
                            Result<RcPermission> resultP = biz.getPermission(rcRolePermissions.getPermissionId());
                            if (resultP.isStatus()) {
                                permissionSet.add(resultP.getResultData().getPermissionsValue());
                            }
                        }
                    }
                }
            }
        }
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userno = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        Result<RcUser> result = biz.login(userno, password);
        if (result.isStatus()) {
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute(Constants.Token.RONCOO, userno);
            RcUser user = result.getResultData();
            return new SimpleAuthenticationInfo(user.getUserNo(), user.getPassword(), getName());
        }
        return null;
    }
}
