package com.project_aurora.emu.coreutils


/** 
 * @see Proc class for more information
 * This Interface represents mainly functions you could use with of Process 
 */ 
interface IProc {
    abstract fun map(proc: Shell.Proc<*>)
    abstract fun deMap(proc: Shell.Proc<*>)
    abstract fun waitFor(callback: Callback<String>, proc: Shell.Proc<*>)
}

interface Callback<T> {
    var output: String
    fun getProcResult(result: T) : String {
        return output
    }
}


/** 
 * class Shell
 */
class Shell : IProc {
    /** 
     * This class represents a Process to runner
     * @property mName this represents name of Process git for example (String, Int, Boolean and more Types)
     */
    inner class Proc<T>(
        var mName: T? = null,
        var mProcessId: Int,
        var mCommand: String,
        var mArgs: String,
        vararg mEnvs: String,
        var mCwd: String,
        var mFd: Int ) {
        
        /**
         * @property store output of Process runner
         */
        var output: String = "NULL"
    }
    /** list of process for execution */
    private var procs: MutableMap<Int, Proc<*>> = mutableMapOf()
    
    
    /** 
      * @see IProc 
      * IProc functions implementation
      */
    override fun map(proc: Proc<*>) {
        procs[proc.mProcessId] = proc
    }
    
    override fun deMap(proc: Proc<*>) {
        procs.remove(proc.mProcessId)
    }
    
    override fun waitFor(callback: Callback<String>, proc: Proc<*>) {
        /** when complete call callback */
        callback.output = proc.output
    }
}
