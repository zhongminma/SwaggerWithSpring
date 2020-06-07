package com.kevin.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Entity Bean")
public class User {
    @ApiModelProperty("login name")
    public String username;
    @ApiModelProperty("personal pwd")
    public String password;
}
