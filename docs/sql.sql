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


create table club_member
(
    id INTEGER auto_increment,
    user_id int not null comment '成员id',
    club_id int null comment '社团id',
    apply_time bigint null comment '申请时间',
    pass_time bigint null comment '通过时间',
    state bool null comment '是否审批通过',
    constraint club_member_pk
        primary key (id)
)
    comment '社团成员记录';

create unique index club_member_club_id_uindex
    on club_member (club_id);

create unique index club_member_user_id_uindex
    on club_member (user_id);


create table activity
(
    id INTEGER auto_increment,
    activity_name varchar(50) null comment '活动名称',
    activity_theme varchar(500) null comment '活动主题',
    activity_description varchar(1000) null comment '活动介绍',
    satrt_time bigint null comment '活动开始时间',
    end_time bigint null comment '活动结束时间',
    club_id int null comment '主办社团id',
    user_id int null comment '主办人id',
    request_method int null comment '通过报名者请求方式，0手动审核，1自动通过所有',
    state bool null comment '活动是否通过审核',
    constraint activity_pk
        primary key (id)
)
    comment '活动记录';

create unique index activity_club_id_uindex
    on activity (club_id);


create table active_record
(
    id INTEGER null comment '记录id',
    user_id int null comment '报名者id',
    activity_id int null comment '活动id',
    register_time bigint null comment '报名时间',
    state bool null comment '是否通过审核'
)
    comment '活动包名记录';

