package com.geekwise.hackerrank.solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

		try {
			String line = inp.readLine();

			String[] lineArr = line.split(" ");
			int N = Integer.parseInt(lineArr[0]);
			int Q = Integer.parseInt(lineArr[1]);
			int lastAnswer = 0;
			List<Integer>[] seqList = new ArrayList[N];
			while (Q > 0) {
				line = inp.readLine();
				lineArr = line.split(" ");

				int type = Integer.parseInt(lineArr[0]);
				int x = Integer.parseInt(lineArr[1]);
				int y = Integer.parseInt(lineArr[2]);

				int xorValue = ((x ^ lastAnswer) % N);
				List<Integer> seq = new ArrayList<>();
				if (seqList.length !=0 && seqList.length > xorValue) {
					seq = seqList[xorValue];
					if(seq == null) {
						seq = new ArrayList<>();
					}
				}
				if (type == 1) {
					seq.add(y);
					seqList[xorValue] = seq;
				} else{
					int elemPos = y % seq.size();
					if (!seq.isEmpty())
						lastAnswer = seq.get(elemPos);
					System.out.println(lastAnswer);
				}
				Q--;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
