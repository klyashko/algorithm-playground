package com.algorithm.playground.utils

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo

class RepeatExtension extends AbstractAnnotationDrivenExtension<Repeat> {

	@Override
	void visitFeatureAnnotation(Repeat annotation, FeatureInfo feature) {
		feature.reportIterations = true
		feature.addInterceptor(new RepeatInterceptor(annotation.value()))
	}
}
