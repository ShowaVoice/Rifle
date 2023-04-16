package org.bullet;

import org.bullet.exceptions.*;
import org.bullet.exceptions.RuntimeException;
import org.bullet.interpreter.BulletRuntime;

import java.io.File;
import java.io.IOException;

/**
 * @author Huyemt
 */

public class Shell {
    public static void main(String[] args) {
        try {
            CompiledBullet compiled = new CompiledBullet(new File("E:\\AMyCode\\Tool\\Rifle\\modules\\test.bt"), new BulletRuntime());
            compiled.eval();
        } catch (ParsingException e) {
            System.out.println(Reporter.report(e.getClass().getName(), e.position, e.getMessage()));
        } catch (RuntimeException e) {
            System.out.println(Reporter.report(e.getClass().getName(), e.position, e.getMessage()));
        } catch (IOException | BulletException e) {
            throw new java.lang.RuntimeException(e);
        }
    }
}
