/* This file was generated by SableCC (http://www.sablecc.org/). */

package nisse.node;

import nisse.analysis.*;

@SuppressWarnings("nls")
public final class AExclamationCharall extends PCharall
{
    private TExclamation _exclamation_;

    public AExclamationCharall()
    {
        // Constructor
    }

    public AExclamationCharall(
        @SuppressWarnings("hiding") TExclamation _exclamation_)
    {
        // Constructor
        setExclamation(_exclamation_);

    }

    @Override
    public Object clone()
    {
        return new AExclamationCharall(
            cloneNode(this._exclamation_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExclamationCharall(this);
    }

    public TExclamation getExclamation()
    {
        return this._exclamation_;
    }

    public void setExclamation(TExclamation node)
    {
        if(this._exclamation_ != null)
        {
            this._exclamation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._exclamation_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._exclamation_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._exclamation_ == child)
        {
            this._exclamation_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._exclamation_ == oldChild)
        {
            setExclamation((TExclamation) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}