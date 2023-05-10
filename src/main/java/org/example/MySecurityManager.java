package org.example;

import java.security.Permission;

/**
 * @Author Zhixiang Shang
 * @Date 10.05.2023 10:49
 * @Version 1.0
 */
public class MySecurityManager extends SecurityManager {

    @Override
    public void checkRead(String file) {
        if (!file.equals("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\demo.xml")) {
            throw new SecurityException("Reading files other than demo.xml is not allowed");
        }
    }

    @Override
    public void checkWrite(String file) {
        if (!file.equals("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\demo.xml")) {
            throw new SecurityException("Writing files other than demo.xml is not allowed");
        }
    }

    @Override
    public void checkDelete(String file) {
        if (!file.equals("E:\\sandBox\\sandBox\\src\\main\\java\\org\\example\\demo.xml")) {
            throw new SecurityException("Deleting files other than demo.xml is not allowed");
        }
    }

    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("Executing system commands is not allowed");
    }

    @Override
    public void checkLink(String lib) {
        throw new SecurityException("Loading external libraries is not allowed");
    }

}
