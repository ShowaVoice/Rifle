package org.bullet.base.components;

import org.bullet.base.types.BtArray;
import org.bullet.base.types.BtDictionary;
import org.bullet.exceptions.BulletException;
import org.bullet.interpreter.BulletRuntime;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Bullet的函数
 * <br><br>
 * Function of Bullet
 *
 * @author Huyemt
 */

public abstract class BtFunction {
    public final String funcName;
    protected final BulletRuntime runtime;

    public BtFunction(String funcName, BulletRuntime runtime) {
        this.funcName = funcName;
        this.runtime = runtime;
    }

    /**
     * 函数调用
     * <br><br>
     * Call the function
     *
     * @param args
     * @throws BulletException
     */
    public void invoke(Object ... args) throws BulletException {
        this.invokeFV(args);
    }

    /**
     * 函数调用并获取返回值
     * <br><br>
     * Call the function and get the return value
     *
     * @param args
     * @return Object
     * @throws BulletException
     */
    public abstract Object invokeFV(Object ... args) throws BulletException;

    public final String getName() {
        return funcName;
    }

    @Override
    public String toString() {
        return "Function:".concat(funcName);
    }

    protected final Object parseBaseType(Object v) {
        if (v instanceof Integer || v instanceof Float || v instanceof Double) {
            return new BigDecimal(v.toString());
        }

        if (v.getClass().isArray()) {
            return BtArray.parse((Object[]) v);
        }

        if (v instanceof Map) {
            return BtDictionary.parse((Map<String, Object>) v);
        }

        return v;
    }
}
