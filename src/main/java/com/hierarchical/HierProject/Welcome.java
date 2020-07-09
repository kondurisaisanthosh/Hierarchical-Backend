package com.hierarchical.HierProject;

import com.hierarchical.HierProject.bean.UserBean;
import com.hierarchical.HierProject.exception.ApiRequestException;
import com.hierarchical.HierProject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserBean authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
//        	return "inavalid username/password server";
            throw new ApiRequestException("Inavalid Credentials");
        }
        return jwtUtil.generateToken(authRequest.getUsername());
    }
}