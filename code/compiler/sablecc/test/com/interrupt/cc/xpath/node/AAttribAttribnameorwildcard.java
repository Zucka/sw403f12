/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.interrupt.cc.xpath.node;

import com.interrupt.cc.xpath.analysis.*;

@SuppressWarnings("nls")
public final class AAttribAttribnameorwildcard extends PAttribnameorwildcard
{
    private PAttributename _attributename_;

    public AAttribAttribnameorwildcard()
    {
        // Constructor
    }

    public AAttribAttribnameorwildcard(
        @SuppressWarnings("hiding") PAttributename _attributename_)
    {
        // Constructor
        setAttributename(_attributename_);

    }

    @Override
    public Object clone()
    {
        return new AAttribAttribnameorwildcard(
            cloneNode(this._attributename_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAttribAttribnameorwildcard(this);
    }

    public PAttributename getAttributename()
    {
        return this._attributename_;
    }

    public void setAttributename(PAttributename node)
    {
        if(this._attributename_ != null)
        {
            this._attributename_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._attributename_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._attributename_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._attributename_ == child)
        {
            this._attributename_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._attributename_ == oldChild)
        {
            setAttributename((PAttributename) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}