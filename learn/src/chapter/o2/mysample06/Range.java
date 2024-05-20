package chapter.o2.mysample06;

record Range(int from, int to) {
	public Range {
		if(from > to) {
			int temp = from;
			from = to;
			to = temp;
		}
	}
}
