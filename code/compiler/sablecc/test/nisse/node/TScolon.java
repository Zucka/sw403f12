/* This file was generated by SableCC (http://www.sablecc.org/). */

package nisse.node;

import nisse.analysis.*;

@SuppressWarnings("nls")
public final class TScolon extends Token
{
    public TScolon()
    {
        super.setText(";");
    }

    public TScolon(int line, int pos)
    {
        super.setText(";");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TScolon(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTScolon(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TScolon text.");
    }
}