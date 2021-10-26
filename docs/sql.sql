-- 用户信息
create table user
(
    user_id     int auto_increment
        primary key,
    user_avatar longblob    null,
    name        varchar(30) null comment '姓名',
    account     varchar(50) null comment '账号',
    password    varchar(50) null comment '密码',
    phone       varchar(20) null comment '电话',
    email       varchar(50) null comment '邮箱',
    sex         varchar(10) null comment '性别',
    permit      int         null comment '用户权限',
    grade       int         null comment '班级id'
)comment '用户信息';


create table grade
(
    grade_id int auto_increment,
    grade_name varchar(100) not null,
    constraint grade_pk
        primary key (grade_id)
)
    comment '班级';


create table club
(
    club_id int auto_increment comment '社团id',
    club_avatar blob null comment '社团头像',
    club_name varchar(50) null comment '社团名称',
    introduction varchar(800) null comment '社团简介',
    slogan varchar(100) null comment '社团口号',
    president_id int null comment '社长用户id',
    create_time long null comment '社团成立时间',
    admin1 int null comment '一号管理员',
    admin2 int null comment '二号管理员',
    admin3 int null comment '三号管理员',
    state int null comment '审批审批状态',
    constraint club_pk
        primary key (club_id)
)
    comment '社团';


