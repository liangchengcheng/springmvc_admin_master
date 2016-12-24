package com.lcc.controller.admin;

import com.lcc.util.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin/security/")
public class SecurityController extends BaseController{

    @RequestMapping(value = LIST, method = RequestMethod.GET)
    public void list() {

    }
}
