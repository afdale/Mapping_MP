package com.agneshandayani.mapping_mp

class Container {

    var mnomesin: String? = null
    var mop1: String? = null
    var mop2: String? = null
    var mop3: String? = null
    var mop4: String? = null
    var mop5: String? = null
    var mKey: String? = null
    var mvalueshift : Int? = null
    var mstart: Long? = null

    constructor(
        mesin: String?,
        op1: String?,
        op2: String?,
        op3: String?,
        op4: String?,
        op5: String?,
        key: String?,
        valueshift: Int?,
        start: Long?

    ) {
        this.mnomesin = mesin

        this.mop1 = op1
        this.mop2 = op2
        this.mop3 = op3
        this.mop4 = op4
        this.mop5 = op5
        this.mKey = key
        this.mvalueshift = valueshift
        this.mstart = start
    }
    fun getemstart(): Long? {
        return mstart
    }

    fun setmstart(start: Long?) {
        mstart = start
    }

    fun getKey(): String? {
        return mKey
    }

    fun setKey(key: String?) {
        mKey = key
    }


    fun getmop1(): String? {
        return mop1
    }

    fun setmop1(op1: String?) {
        mop1 = op1
    }

    fun getmop2(): String? {
        return mop2
    }

    fun setmop2(op2: String?) {
        mop2 = op2
    }

    fun getmop3(): String? {
        return mop3
    }

    fun setmop3(op3: String?) {
        mop3 = op3
    }

    fun getmop4(): String? {
        return mop4
    }

    fun setmop4(op4: String?) {
        mop4 = op4
    }
    fun getmop5(): String? {
        return mop5
    }

    fun setmop5(op5: String?) {
        mop5 = op5
    }

    fun getmKey(): String? {
        return mKey
    }

    fun setmKey(key: String?) {
        mKey = key
    }

    fun getnomesin(): String? {
        return mnomesin
    }

    fun setnomesin(mesin: String?) {
        mnomesin = mesin
    }
    fun getmvalueshift (): Int? {
        return mvalueshift
    }
    fun setmvalueshift (valueshift: Int?) {
        mvalueshift = valueshift
    }
}