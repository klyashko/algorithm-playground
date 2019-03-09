package com.algorithm.playground.data.structure;

import java.util.Objects;

public class Tuple2<T1, T2> {

	public final T1 _1;
	public final T2 _2;

	public Tuple2(T1 _1, T2 _2) {
		this._1 = _1;
		this._2 = _2;
	}

	public T1 _1() {
		return _1;
	}

	public T2 _2() {
		return _2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o == null || getClass() != o.getClass()) {
			return false;
		} else {
			Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;
			return Objects.equals(_1, tuple2._1) && Objects.equals(_2, tuple2._2);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(_1, _2);
	}

	@Override
	public String toString() {
		return "Tuple2{" +
				"_1=" + _1 +
				", _2=" + _2 +
				'}';
	}
}
