
import unittest

from digit_sum import *


class TestAb4_2(unittest.TestCase):
	
	def setUp(self):
		methodImplemented = True

		try:
			digit_sum
			# Zugriff auf quersumme wirft einen NameError, wenn quersumme nicht vorhanden ist
			# Bei Instanzmethoden wird dies zu einem AttributeError
		except (NameError, AttributeError):
			# Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
			methodImplemented = False

		if not methodImplemented:
			self.fail("Die Lösung kann nicht getestet werden. Eine Funktion \"def digit_sum(n):\" fehlt!")

	# NOTE: for loops in tests are bad practice, because it takes longer to find out which
	# line actually led to an error.
	# If you *have* to do systematic tests with multiple inputs, adjust the error message,
	# such that it immediately shows the index variable.
	# NOTE: Also: In tests for students they lead to the requirement for a reference implementation.
	# If you would just test three hardcoded numbers, you could also hardcode the expected result. ;)
	def test_single_digit_numbers(self):
		for n in range(1,10): # Einstellige Zahlen sind identisch mit ihrer Quersumme
			self.assertEqual(n, digit_sum(n), f"Der Output stimmt bei der Zahl {n} nicht mit der Lösung überein.")

	def test_big_numbers(self):
		for exp in range(1,5):
			n = 10 ** exp # Fügt Nullen an, um Zahlen größer zu machen, Ergebnis bleibt 1
			self.assertEqual(1, digit_sum(n), f"Der Output stimmt bei der Zahl {n} nicht mit der Lösung überein.")

	def test_10_to_1000(self):
		for n in range(10, 1000):
			self.assertEqual(self.reference_quersumme(n), digit_sum(n), f"Der Output stimmt bei der Zahl {n} nicht mit der Lösung überein.")


	def reference_quersumme(self, n):
		# // operator performs integer division
		return n if (n <= 9) else (n % 10 + self.reference_quersumme(n // 10))


if __name__ == '__main__':
	unittest.main()