<?php
$start = microtime(true);
 
define('PATH', '/'); 
define('ROOT_PATH', dirname(__FILE__));
$page = 'Home';

if(!ini_get('upload_tmp_dir')){
	$tmp_dir = sys_get_temp_dir();
} else {
	$tmp_dir = ini_get('upload_tmp_dir');
}

ini_set('open_basedir', ROOT_PATH . PATH_SEPARATOR  . $tmp_dir);

$directory = $_SERVER['REQUEST_URI'];
$page_path = $_SERVER['REQUEST_URI'];
if (preg_match("/\?/", $page_path)) {
	$page_path = substr($page_path, 0, strpos($page_path, "?"));
	$page_query = substr($_SERVER['REQUEST_URI'], strpos($_SERVER['REQUEST_URI'], "?") + 1);
}

$directories = explode("/", $directory);
$lim = count($directories);

require("core/core.php");

if($page_path == "/" || $page_path == "/home"){
	require("pages/index.php");
} elseif(is_file($page_path)){
	require($page_path);
} elseif(is_file('pages/' . $page_path . '.php')){
	require('pages/' . $page_path . '.php');
} elseif(is_dir('pages/' . $page_path)){
	if(file_exists('pages/' . $page_path . '/index.php')){
		require('pages/' . $page_path . '/index.php');
	}
} else {
	require('404.php');
}

?>