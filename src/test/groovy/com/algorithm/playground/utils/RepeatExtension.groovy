package com.algorithm.playground.utils

import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo

class RepeatExtension extends AbstractAnnotationDrivenExtension<Repeat> {

	@Override
	void visitFeatureAnnotation(Repeat annotation, FeatureInfo feature) {
		feature.addInterceptor(new RepeatInterceptor(annotation.value()))
	}
}
