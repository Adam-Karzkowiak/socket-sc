package server.model;

import server.model.utility.Privileges;

import javax.validation.constraints.NotNull;

class AppUser {
    @NotNull
    String login;
    @NotNull
    String password;
    Privileges privileges;
}
