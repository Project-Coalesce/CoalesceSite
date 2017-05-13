<?php

chdir("/home/allml/al1l.com");

$mysql_login = array(
	'host' => 'localhost',
	'port' => '3306',
	'username' => 'allml_voltiac',
	'password' => 'VoltiacAdm1n876',
	'database' => 'allml_voltiac',
	'prefix' => 'al1l_'
);
$mysql = mysqli_connect($mysql_login['host'], $mysql_login['username'], $mysql_login['password'], $mysql_login['database'], $mysql_login['port']);

if (!$mysql) {
    die("Can't connect to database! (" . $mysqlblox->connect_error . ")");
}