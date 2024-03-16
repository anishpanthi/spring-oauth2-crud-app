CREATE TABLE IF NOT EXISTS USERS
(
    ID       serial primary key,
    NAME     varchar(100) NOT NULL,
    EMAIL    varchar(100) NOT NULL
);

-- insert into USERS (NAME, EMAIL) values ('Anish','anish@whoisanish.com');
-- insert into USERS (NAME, EMAIL) values ('John','john@iamjohn.com');
-- insert into USERS (NAME, EMAIL) values ('Pamiadu','pami@adu.com');
-- insert into USERS (NAME, EMAIL) values ('Jake','jake@gmail.com');
-- insert into USERS (NAME, EMAIL) values ('John','john@okta.com');
-- insert into USERS (NAME, EMAIL) values ('Robert','robert@gmail.com');
-- insert into USERS (NAME, EMAIL) values ('Okta Hero','oktahero@okta.com');
-- insert into USERS (NAME, EMAIL) values ('Hello','hello@world.com');
-- insert into USERS (NAME, EMAIL) values ('World','world@hello.com');
-- insert into USERS (NAME, EMAIL) values ('Gmail','gmail@gmail.com');
