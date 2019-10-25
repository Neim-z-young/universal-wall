
DROP TABLE if EXISTS `wall_users`;
CREATE TABLE `wall_users`(
	`id` int not NULL auto_increment,
	`username` VARCHAR(50) COMMENT"用户唯一名称",
	`password` VARCHAR(128) COMMENT"加密后的密码",
	`email` VARCHAR(256),
	`open_id` VARCHAR(30) COMMENT"微信openid",
	`nick_name` VARCHAR(50) COMMENT"昵称, 可与他人重复",
	`last_login` int,
	`signup_time` int,
	`status` TINYINT(1) COMMENT"帐号启用状态：0->禁用；1->启用",
	`is_online` TINYINT(1) COMMENT"是否在线",
	`gender` int(1) COMMENT"0->未知,1->男,2->女",
	`growth` int COMMENT"成长值",
	`points` int COMMENT"用户积分",
	PRIMARY KEY(`id`),
	unique(`open_id`),
	UNIQUE(`username`)
)auto_increment=10000;

DROP TABLE if EXISTS `wall_user_details`;
CREATE TABLE `wall_user_details`(
	`id` int not null auto_increment,
	`user_id` int,
	`role_id` int,
	`university` VARCHAR(100),
	`school_number` VARCHAR(64),
	`is_real_name_registered` TINYINT(1) COMMENT"是否实名",
	`id_card` VARCHAR(64),
	`first_name` VARCHAR(30),
	`last_name` VARCHAR(150),
	`phone_number` VARCHAR(64),
	PRIMARY KEY(`id`),
	UNIQUE(`user_id`),
	UNIQUE(`school_number`)
)auto_increment=1;

DROP TABLE if EXISTS `wall_admin`;
CREATE TABLE `wall_admin`(
	`id` int not NULL auto_increment,
	`username` VARCHAR(150),
	`password` VARCHAR(128) COMMENT"加密后的密码",
	`email` VARCHAR(256),
	`nick_name` VARCHAR(30),
	`note` VARCHAR(200) COMMENT"备注信息",
	`last_login` int,
	`signup_time` int,
	`status` TINYINT(1) COMMENT"帐号启用状态：0->禁用；1->启用",
	`is_online` TINYINT(1) COMMENT"是否在线",
	PRIMARY KEY(`id`),
	UNIQUE(`username`)
)auto_increment=10000;

DROP TABLE if EXISTS `wall_user_login_log`;
CREATE TABLE `wall_user_login_log`(
	`id` int not NULL auto_increment,
	`user_id` int,
	`create_time` INT,
	`ip_address` BIGINT COMMENT"通过INET_ATON()/INET_NTOA()转换",
	PRIMARY KEY(`id`)
);

DROP TABLE if EXISTS `wall_admin_login_log`;
CREATE TABLE `wall_admin_login_log`(
	`id` int not NULL auto_increment,
	`admin_id` int,
	`create_time` INT,
	`ip_address` BIGINT COMMENT"通过INET_ATON()/INET_NTOA()转换",
	PRIMARY KEY(`id`)
);

DROP TABLE if EXISTS `postings`;
CREATE table `postings`(
	`id` int not NULL auto_increment,
	`theme` VARCHAR(50) COMMENT"帖子主题",
	`brief_introduction` VARCHAR(50) COMMENT"简易说明，由后端截取",
	`detailed_introduction` VARCHAR(500) COMMENT"详细说明",
	`picture_introduction` VARCHAR(1000) COMMENT"图片说明",
	`release_time` int,
	`poster_id` int COMMENT"发帖者id",
	`category_id` int,
	PRIMARY key(`id`)
	);

DROP TABLE if EXISTS `postings_statistics`;
CREATE table `postings_statistics`(
	`id` int not NULL auto_increment,
	`theme_id` int,
	`click_times` int COMMENT"点击次数",
	`last_modify` int COMMENT"最后修改时间",
	`last_view` int COMMENT"最后阅览时间",
	`poster_id` int,
	`category_id` int,
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `floors`;
CREATE TABLE `floors`(
	`id` int not NULL auto_increment,
	`theme_id` int,
	`reply_time` int,
	`comment` VARCHAR(200),
	`user_id` int,
	`is_read` TINYINT(1) COMMENT"是否查看",
	PRIMARY key(`id`)
	);
DROP TABLE if EXISTS `inside_floors`;
CREATE table `inside_floors`(
	`id` int not NULL auto_increment,
	`floors_id` int COMMENT"楼层id",
	`reply_time` int,
	`comment` varchar(200),
	`user_id` int,
	`is_read` TINYINT(1),
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `wall_user_message`;
CREATE TABLE `wall_user_message`(
	`id` int not NULL auto_increment,
	`user_id` int,
	`message` varchar(100) COMMENT"key:value(theme:int;floor:int;inside_floor:int)",
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `wall_user_statistics`;
CREATE TABLE `wall_user_statistics`(
	`id` int not NULL auto_increment,
	`user_id` int,
	`postings_num` int COMMENT"发帖数",
	`unread_messages` int COMMENT"未读消息",
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `categories`;
CREATE TABLE `categories`(
	`id` int not NULL auto_increment,
	`category` varchar(50) COMMENT"帖子类别",
	`introduction` VARCHAR(200),
	`create_time` int,
	`top_postings` int COMMENT"置顶帖",
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `permissions`;
CREATE TABLE `permissions`(
	`id` int not NULL auto_increment,
	`peimission` varchar(20) COMMENT"用户权限",
	`introduction` varchar(200),
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `roles`;
CREATE TABLE `roles`(
	`id` int not NULL auto_increment,
	`name` varchar(50) COMMENT"角色",
	`introduction` varchar(200),
	PRIMARY KEY(`id`)
	);

DROP TABLE if EXISTS `role_permission_relation`;
CREATE TABLE `role_permission_relation`(
	`id` int not NULL auto_increment,
	`permission_id` int,
	`role_id` int,
	PRIMARY KEY(`id`)
	);

	DROP TABLE if EXISTS `admin_role_relation`;
	CREATE TABLE `admin_role_relation`(
		`id` int not NULL auto_increment,
		`admin_id` int,
		`role_id` int,
		PRIMARY KEY(`id`)
		);