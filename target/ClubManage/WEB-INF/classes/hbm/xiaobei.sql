CREATE TABLE `user`
(
    `uid`      bigint                                                NOT NULL AUTO_INCREMENT,
    `account`  bigint                                                NOT NULL,
    `password` varchar(20)                                           NOT NULL,
    `permit`   int                                                   NOT NULL,
    `name`     varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `sex`      varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci  DEFAULT NULL,
    `phone`    varchar(11)                                            DEFAULT NULL,
    `grade`    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    `position` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
    PRIMARY KEY (`uid`),
    UNIQUE KEY `user_account_uindex` (`account`)
);

insert into `user`(`uid`, `account`, `password`, `name`, `permit`, `sex`, `phone`, `grade`, `position`)
values (1, 19100001, '123456', '张三', 1, '男', '18210104438', '大一', ''),
       (2, 19100002, '123456', '李芳', 0, '女', '18220204438', '大一', ''),
       (3, 19100003, '123456', '王强', 0, '男', '18230304438', '大二', ''),
       (4, 19100004, '123456', '赵欣', 1, '女', '1824040', '大三', ''),
       (5, 19100005, '123456', '孙浩', 0, '男', '18250504438', '大二', ''),
       (6, 19100006, '123456', '李可欣', 0, '女', '18260604438', '大四', ''),
       (7, 19100007, '123456', '戴四', 1, '男', '18270704438', '大一', ''),
       (8, 19100008, '123456', '方佳欣', 0, '女', '18280804438', '大一', ''),
       (9, 19100009, '123456', '王菲', 0, '女', '18290904438', '大三', ''),
       (10, 19100010, '123456', '陈浩南', 1, '男', '18210114438', '大四', '');


create table club
(
    cid          bigint auto_increment
        primary key,
    cname        varchar(10) charset utf8 not null,
    admin1       bigint                   null,
    admin2       bigint                   null,
    admin3       bigint                   null,
    introduction text                     null,
    scene        varchar(500)             null,
    state        int                      not null
);

insert into `club`(`cid`, `cname`, `admin1`, `admin2`, `admin3`, `scene`, `state`)
values (1, '滑板社', 1, 2, 3, '', 1),
       (2, '516轮滑', 4, 5, 6, '', 1),
       (3, '绿野寻踪社', 7, 8, 9, '', 1),
       (4, '汉服社', 10, 11, 12, '', 1),
       (5, '科技探索社', 2, null, null, '', 0),
       (6, 'ACM竞赛社', 8, null, null, '', -1);


create table member
(
    uid      bigint default 0 not null,
    cid      bigint default 0 not null,
    permit   int              not null,
    position varchar(15)      null,
    state1   int              not null,
    state2   int              null,
    primary key (uid, cid)
);


create table notice
(
    nid    bigint auto_increment
        primary key,
    cid    bigint   not null,
    tittle tinytext null,
    text   text     null
);

create table activity
(
    aid         bigint auto_increment,
    cid         bigint not null,
    state       int,
    place       varchar(25),
    theme       text,
    goal        text,
    description text,
    constraint activity_pk
        primary key (aid)
);

INSERT INTO activity (aid, cid, state, place, theme, goal, description)
VALUES (1, 1001, -1, 'YMQ', 'AA', 'BB', 'CC');

INSERT INTO activity (aid, cid, state, place, theme, goal, description)
VALUES (2, 1002, 0, '111', 'AA', 'BB', 'CC');

INSERT INTO activity (aid, cid, state, place, theme, goal, description)
VALUES (3, 1003, 1, 'c301', '', '', '');

create table attend
(
    aid bigint auto_increment
        primary key,
    uid bigint not null
);