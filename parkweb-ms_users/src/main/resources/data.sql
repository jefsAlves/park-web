INSERT INTO TB_USERS (NAME, EMAIL, PASSWORD) VALUES ('Bob', 'bob@gmail.com', '$2a$10$vwIKYLKzQWNm9dR61ZSxmO7kD4.LnsNDAF5dkt6KbS0TlCLOAcHty');
INSERT INTO TB_USERS (NAME, EMAIL, PASSWORD) VALUES ('Alex', 'alex@gmail.com', '$2a$10$GTD3FBsR/OSDJLr9exVuMOUjXE556kbUb/tOBtI4EUuyUJ9Lbtnj.');
INSERT INTO TB_USERS (NAME, EMAIL, PASSWORD) VALUES ('Chris', 'chris@gmail.com', '$2a$10$gY/btXvISorAqqOSoAua0.NXISc0cnPEyBpKWJVD6TiK1mplk4HXa');

INSERT INTO TB_ROLES (ROLE_NAME) VALUES ('ROLE_OPERATOR');
INSERT INTO TB_ROLES (ROLE_NAME) VALUES ('ROLE_ADM');

INSERT INTO TB_USERS_ROLES (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO TB_USERS_ROLES (USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO TB_USERS_ROLES (USER_ID, ROLE_ID) VALUES (2, 2);