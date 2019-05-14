package com.algorithm.playground.data.structure;

public class IntITuple2 {

	private final int _1, _2;

	public IntITuple2(int _1, int _2) {
		this._1 = _1;
		this._2 = _2;
	}

	public int _1() {
		return _1;
	}

	public int _2() {
		return _2;
	}

	@Override
	public String toString() {
		return "[" + _1 + ',' + _2 + ']';
	}

}
