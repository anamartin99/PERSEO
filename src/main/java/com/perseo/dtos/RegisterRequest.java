package com.perseo.dtos;

public interface RegisterRequest {

    String getUsername();
    String getPassword();

    static RegisterRequest create(String username, String password) {
        return new RegisterRequestImpl(username, password);
    }

    class RegisterRequestImpl implements RegisterRequest {
        private final String username;
        private final String password;

        private RegisterRequestImpl(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "RegisterRequestImpl{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}