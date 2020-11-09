package com.company.project.configurer;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.util.Properties;

/**
 * ssh链接工具类,链接到ssh server
 */
public class SSHConnection {

    /**
     *
     */
    private final static String S_PATH_FILE_PRIVATE_KEY = "";

    /**
     *
     */
    private final static String S_PATH_FILE_KNOWN_HOSTS = "";

    /**
     *
     */
    private final static String S_PASS_PHRASE = "";

    /**
     * 本地代理端口
     */
    private final static int LOCAL_PORT = 3307;

    /**
     * 远程数据库端口
     */
    private final static int REMOTE_PORT = 3306;

    /**
     * 远程服务器端口
     */
    private final static int SSH_REMOTE_PORT = 22;

    /**
     * 服务器登录名
     */
    private final static String SSH_USER = "root";


    /**
     * 服务器登录密码
     */
    private final static String SSH_PASSWORD = "Qdtv12#$";


    /**
     * 服务器登录地址
     */
    private final static String SSH_REMOTE_SERVER = "192.16.36.195";


    /**
     * 数据库登录地址
     */
    private final static String MYSQL_REMOTE_SERVER = "127.0.0.1";

    private final int LOCAl_PORT = 3307;


    /**
     * represents each ssh session
     */
    private Session sesion;


    /**
     * 关闭链接
     */
    public void closeSSH(){

        sesion.disconnect();
    }

    /**
     *
     * @throws Throwable
     */
    public SSHConnection () throws Throwable
    {

        JSch jsch = null;

        jsch = new JSch();
        jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
        //jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY);

        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);

        sesion.setPassword(SSH_PASSWORD);

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        sesion.setConfig(config);

        sesion.connect(); //ssh connection established!

        //by security policy, you must connect through a fowarded port
        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT);

    }




}
