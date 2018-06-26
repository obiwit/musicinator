public enum Type {
		NUMBER, SEQUENCE, PERFORMANCE, INSTRUMENT, 
		NUMBER_ARRAY, SEQUENCE_ARRAY, PERFORMANCE_ARRAY, INSTRUMENT_ARRAY,
		ERROR;

		public static boolean isSimpleType(Type t) {
			return (t == NUMBER || t == SEQUENCE || t == PERFORMANCE || t == INSTRUMENT);
		}

		public static Type toArrayType(Type t) {
			assert isSimpleType(t);

			switch(t) {
				case NUMBER: 	  
					return NUMBER_ARRAY;
				case SEQUENCE: 	  
					return SEQUENCE_ARRAY;
				case PERFORMANCE: 
					return PERFORMANCE_ARRAY;
				case INSTRUMENT:  
					return INSTRUMENT_ARRAY;
				default:
					return t;
			}
		}
		public static Type toSimpleType(Type t) {
			assert (!isSimpleType(t) && t != ERROR);

			switch(t) {
				case NUMBER_ARRAY: 	  
					return NUMBER;
				case SEQUENCE_ARRAY: 	  
					return SEQUENCE;
				case PERFORMANCE_ARRAY: 
					return PERFORMANCE;
				case INSTRUMENT_ARRAY:  
					return INSTRUMENT;
				default:
					return t;
			}
		}
}