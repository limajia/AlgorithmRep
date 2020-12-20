package mianshi;

import java.util.LinkedHashMap;

class TestMainshi {
	public static void main(String args[]) {
		prob1 f = new prob1();
		System.out.println("puzzel of 6 is = " + f.puzzel(6));
	}

	public static class MyLinkedHashMap extends LinkedHashMap {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
			// TODO Auto-generated method stub
			return size() > MAX_ENTRIES;
		}

		private static int MAX_ENTRIES = 10;

		/**
		 * 获得允许存放的最大容量
		 * 
		 * @return int
		 */
		public static int getMAX_ENTRIES() {
			return MAX_ENTRIES;
		}

		/**
		 * 设置允许存放的最大容量
		 * 
		 * @param int max_entries
		 */
		public static void setMAX_ENTRIES(int max_entries) {
			MAX_ENTRIES = max_entries;
		}
	}
}