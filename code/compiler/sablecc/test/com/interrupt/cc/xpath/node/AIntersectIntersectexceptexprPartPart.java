/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.interrupt.cc.xpath.node;

import com.interrupt.cc.xpath.analysis.*;

@SuppressWarnings("nls")
public final class AIntersectIntersectexceptexprPartPart extends PIntersectexceptexprPartPart
{
    private TKeywordIntersect _keywordIntersect_;

    public AIntersectIntersectexceptexprPartPart()
    {
        // Constructor
    }

    public AIntersectIntersectexceptexprPartPart(
        @SuppressWarnings("hiding") TKeywordIntersect _keywordIntersect_)
    {
        // Constructor
        setKeywordIntersect(_keywordIntersect_);

    }

    @Override
    public Object clone()
    {
        return new AIntersectIntersectexceptexprPartPart(
            cloneNode(this._keywordIntersect_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntersectIntersectexceptexprPartPart(this);
    }

    public TKeywordIntersect getKeywordIntersect()
    {
        return this._keywordIntersect_;
    }

    public void setKeywordIntersect(TKeywordIntersect node)
    {
        if(this._keywordIntersect_ != null)
        {
            this._keywordIntersect_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._keywordIntersect_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._keywordIntersect_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._keywordIntersect_ == child)
        {
            this._keywordIntersect_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._keywordIntersect_ == oldChild)
        {
            setKeywordIntersect((TKeywordIntersect) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}