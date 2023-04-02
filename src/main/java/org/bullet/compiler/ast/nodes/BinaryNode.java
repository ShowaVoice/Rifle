package org.bullet.compiler.ast.nodes;

import org.bullet.compiler.ast.Node;
import org.bullet.compiler.ast.Visitor;
import org.bullet.exceptions.RuntimeException;
import org.bullet.interpreter.Result;

/**
 * @author Huyemt
 */

public class BinaryNode extends Node {
    public enum Operator {
        ADD,
        SUB,
        MUL,
        DIV
    }

    public Operator operator;
    public Node left;
    public Node right;

    @Override
    public Result<?> accept(Visitor visitor) throws RuntimeException {
        return visitor.goBinary(this);
    }
}