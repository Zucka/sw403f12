/* This file was generated by SableCC (http://www.sablecc.org/). */

package nisse.node;

import nisse.analysis.*;

@SuppressWarnings("nls")
public final class ANumeration extends PNumeration
{
    private TNlist _nlist_;
    private PNumerationv1 _numerationv1_;

    public ANumeration()
    {
        // Constructor
    }

    public ANumeration(
        @SuppressWarnings("hiding") TNlist _nlist_,
        @SuppressWarnings("hiding") PNumerationv1 _numerationv1_)
    {
        // Constructor
        setNlist(_nlist_);

        setNumerationv1(_numerationv1_);

    }

    @Override
    public Object clone()
    {
        return new ANumeration(
            cloneNode(this._nlist_),
            cloneNode(this._numerationv1_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANumeration(this);
    }

    public TNlist getNlist()
    {
        return this._nlist_;
    }

    public void setNlist(TNlist node)
    {
        if(this._nlist_ != null)
        {
            this._nlist_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nlist_ = node;
    }

    public PNumerationv1 getNumerationv1()
    {
        return this._numerationv1_;
    }

    public void setNumerationv1(PNumerationv1 node)
    {
        if(this._numerationv1_ != null)
        {
            this._numerationv1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._numerationv1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._nlist_)
            + toString(this._numerationv1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._nlist_ == child)
        {
            this._nlist_ = null;
            return;
        }

        if(this._numerationv1_ == child)
        {
            this._numerationv1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._nlist_ == oldChild)
        {
            setNlist((TNlist) newChild);
            return;
        }

        if(this._numerationv1_ == oldChild)
        {
            setNumerationv1((PNumerationv1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}