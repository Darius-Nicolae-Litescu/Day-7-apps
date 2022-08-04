package darius.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CastUtils<T> {
	public List<T> castObjectToList(Object list, Class<T> classType) {
		List<?> typedList = (List<?>) list;
		if (typedList != null) {
			return typedList.stream().map(classType::cast).collect(Collectors.toList());
		} else {
			return new ArrayList<T>();
		}
	}
}
