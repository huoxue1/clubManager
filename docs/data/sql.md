### 用户 -- user

----

| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| user_id   | int       | 自增       |
| user_avatar | blob | 用户头像 |
|   name    |varchar(20)|   用户姓名 |
| account   |varchar(50)| 用户账号   |
| password | varchar(50) | 用户密码 |
| phone | char(11) | 手机号 |
| email | varchar(30) | 用户邮箱 |
| sex | varchar(10) | 性别 |
| permit |  int | 用户权限，3为普通用户权限，2为管理员权限，1为超级用户权限 |
| grade_id | int | 所属班级id |



### 班级 -- grade
| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| grade_id | int | 班级id |
| grade_name | varchar(100) | 班级名称 |



### 社团 -- club

----

| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| club_id | int | 社团id，自增 |
| club_avatar| blob | 社团标志 |
| club_name | varchar(100) | 社团名称 |
| introduction | varchar(300)| 社团简介 |
| slogan | varchar(100) | 社团口号 |
| president_id | int | 社长用户id |
| create_time | long | 社团成立时间 |
| slogan| varchar(100) | 宣传语 |
| admin1 | int | 一号管理员 |
| admin2 | int | 二号管理员 |
| admin3 | int | 三号管理员 |
| state | int | 社团审批状态,0为未通过,1为通过,-1为拒绝 |



### 社团成员记录 -- club_member

----

| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| id | int | 记录id |
| user_id | int | 成员id |
| club_id | int  | 社团id |
| apply_time | long |申请时间 |
| pass_time | long | 通过时间 |
| state | int | 是否审批通过 |


### 活动记录 activity

---

| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| id | int | 活动id |
| activity_name | varchar(50) | 活动名称 |
| activity_theme | varchar(500) | 活动主题 |
| activity_description | varchar(500) | 活动介绍 |
| start_time | long | 活动开始时间 |
| end_time | long | 活动结束时间 |
| club_id | int | 主办社团id |
| user_id | int | 主办人id |
| request_method | int | 通过报名者请求方式，0手动审核，1自动通过所有审核 |
| state | int | 活动是否通过管理员审核 |


### 活动报名记录表 registration_record
| 列名 | 类型 | 备注 |
| --------- | --------- | --------- |
| id | int | 记录id |
| user_id | int | 报名者id |
| activity_id | int | 活动id |
| register_time | long | 报名时间 |
| state | int | 是否通过审核 |




### 留言板 -- message_board

----










