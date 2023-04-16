package org.rifle;

import org.bullet.Reporter;
import org.bullet.exceptions.BulletException;
import org.bullet.exceptions.ParsingException;

/**
 * @author Huyemt
 */

public class Main {
    public static void main(String[] args) {
        try {
            new Rifle();
        } catch (Exception e) {
            if (e instanceof BulletException) {
                if (e instanceof ParsingException) {
                    Rifle.getInstance().getLogger().error(String.format("\n%s", Reporter.report(e.getClass().getName(), ((ParsingException) e).position, e.getMessage())));
                    Rifle.getInstance().getConsole().shutdown();
                    return;
                }
            }

            Rifle.getInstance().getLogger().error(e.getMessage());
            Rifle.getInstance().getConsole().shutdown();
        }
    }
}
