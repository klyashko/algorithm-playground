package com.algorithm.playground

import org.spockframework.runtime.extension.AbstractMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation

class RepeatInterceptor extends AbstractMethodInterceptor {

	private final int n

	RepeatInterceptor(int n) {
		this.n = n
	}

	@Override
	void interceptFeatureExecution(IMethodInvocation invocation) throws Throwable {
		n.times { invocation.proceed() }
	}
}
