package studentpractice.tranvanthang.qhd;

import java.util.Scanner;

public class bai_toan_dong_xu {

	public static void main(String[] args) {
		int[] min = new int[100];
		// /gia tri khoi tao, co 3 loai dong tien la 1$ 2$ va 5$ thoi
		min[0] = 0;
		min[1] = 1;
		min[2] = 1;
		min[3] = 2;
		min[4] = 2;
		min[5] = 1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Moi nhap so tien lon hon 5 vao: ");
		int a = scanner.nextInt();
		System.out.println();
		for (int i = 6; i <= a; i++) {
			int temp1 = min[i - 5] + 1;// tru dong xu 5 ,2 ,1
			int temp2 = min[i - 2] + 1;
			int temp3 = min[i - 1] + 1;
			int temp_min;// ///temp_min=trung gian tim min giua 3 so temp tren
			temp_min = (temp1 > temp2) ? temp2 : temp1;
			temp_min = (temp_min > temp3) ? temp3 : temp_min;
			min[i] = temp_min;
		}
		for (int i = 6; i <= a; i++) {

			System.out.println("so dong xu nho nhat cau thanh nen " + i
					+ "dong tien la:" + min[i]);
		}

	}

}
