package com.algorithm.playground.google.utils

class GoogleUtils {

	static exec(Runnable runner, List<String>... args) {
		List<List<String>> transposed = args.toList().transpose()
		def outputs = LocalTestRunner.exec(runner, transposed[0] as List<String>)
		def expected = transposed[1].withIndex().collect { el, idx -> "Case #${idx + 1}: ${el}" }

		assert outputs.size() == expected.size()

		return [outputs, expected].transpose()
	}

}
