package Task_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static String input = new String();

	public static void main(String[] args) {
		ArrayList<Commodity> gifts = new ArrayList<>();
		gifts.add(new Commodity("Plate", 30, 30, 200));
		gifts.add(new Commodity("Pan", 42, 52, 880));
		gifts.add(new Commodity("Cup", 10, 20, 150));
		gifts.add(new Commodity("Fork", 20, 5, 40));
		gifts.add(new Commodity("Spoon", 25, 5, 40));
		gifts.add(new Commodity("Knife", 32, 12, 320));
		Scanner scan = new Scanner(System.in);

		while (true) {
			showMenu();
			input = scan.next();
			switch (input) {
			case "11": {
				showCommodity(gifts);
				break;
			}
			case "1": {
				System.out.println("Введіть назву товару");
				String name = scan.next();
				System.out.println("Введіть довжину товару");
				int length = scan.nextInt();
				System.out.println("Введіть висоту товару");
				int width = scan.nextInt();
				System.out.println("Введіть вагу товару");
				int weight = scan.nextInt();
				gifts.add(new Commodity(name, length, width, weight));
				System.out.println("Товар успішно додано!");
				showCommodity(gifts);
				break;
			}
			case "2": {
				System.out.println("Введіть назву товару, який потрібно видалити");
				String name = scan.next();
				Iterator<Commodity> iterator = gifts.iterator();
				while (iterator.hasNext()) {
					Commodity next = iterator.next();
					if (next.getName().toLowerCase().equals(name.toLowerCase())) {
						iterator.remove();
						System.out.println("Товар успішно видалено!");
						showCommodity(gifts);
						break;
					}
				}
				break;
			}
			case "3": {
				System.out.println("Введіть назву товару, який потрібно змінити");
				String name = scan.next();
				Iterator<Commodity> iterator = gifts.iterator();
				while (iterator.hasNext()) {
					Commodity next = iterator.next();
					if (next.getName().toLowerCase().equals(name.toLowerCase())) {
						System.out.println("Введіть нову назву товару" + "(" + "поточна " + next.getName() + ")");
						next.setName(scan.next());
						System.out.println("Введіть нову довжину товару" + "(" + "поточна " + next.getLength() + ")");
						next.setLength(scan.nextInt());
						System.out.println("Введіть нову висоту товару" + "(" + "поточна " + next.getWidth() + ")");
						next.setWidth(scan.nextInt());
						System.out.println("Введіть нову вагу товару" + "(" + "поточна " + next.getWeight() + ")");
						next.setWeight(scan.nextInt());
						System.out.println("Товар успішно замінено!");
						showCommodity(gifts);
						break;
					}
				}
				break;
			}
			case "4": {
				System.out.println("Відсортовано за назвою:");
				Sorter.sortByName(gifts);
				showCommodity(gifts);
				break;
			}
			case "5": {
				System.out.println("Відсортовано за довжиною:");
				Sorter.sortByLength(gifts);
				showCommodity(gifts);
				break;
			}
			case "6": {
				System.out.println("Відсортовано за шириною:");
				Sorter.sortByWidth(gifts);
				showCommodity(gifts);
				break;
			}
			case "7": {
				Sorter.sortByWeight(gifts);
				System.out.println("Відсортовано за вагою:");
				showCommodity(gifts);
				break;
			}
			case "8": {
				System.out.println("Введіть номер товару");
				int input = scan.nextInt();
				if (input > gifts.size()) {
					System.out.println("Товару з цим номером не знайдено!");
					break;
				} else {
					showOneCommodity(gifts.get(input - 1));
					break;
				}
			}
			case "0": {
				System.exit(0);
			}
			}
		}
	}

	public static void showCommodity(ArrayList<Commodity> list) {
		System.out.printf("Назва товару   Довжина   Ширина    Вага\n");
		System.out.printf("------------   -------   ------    ----\n");
		for (Commodity c : list) {
			System.out.printf("%-10s %11d %8d %7d\n", c.getName(), c.getLength(), c.getWidth(), c.getWeight());
		}
	}

	public static void showOneCommodity(Commodity c) {
		System.out.printf("Назва товару   Довжина   Ширина    Вага\n");
		System.out.printf("------------   -------   ------    ----\n");
		System.out.printf("%-10s %11d %8d %7d\n", c.getName(), c.getLength(), c.getWidth(), c.getWeight());
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("1-Додати товар");
		System.out.println("2-Видалити товар");
		System.out.println("3-Замінити товар");
		System.out.println("4-Сортувати товари за назвою");
		System.out.println("5-Сортувати товари за довжиною");
		System.out.println("6-Сортувати товари за шириною");
		System.out.println("7-Сортувати товари за вагою");
		System.out.println("8-Вивести товар за номером");
		System.out.println("0-Exit");
	}
}
