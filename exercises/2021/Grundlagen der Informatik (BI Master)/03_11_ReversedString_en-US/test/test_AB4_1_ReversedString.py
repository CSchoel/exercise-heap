# Ausführen mit:
#	python -m unittest <Dateiname.Des.Tests.py>

# Importiert unittest (In der Standardbibliothek)
import unittest

# From <Datei.Der.Studenten.py> import *
from rev import *
# Ab jetzt sind alle Methoden der Studenten verfügbar

# Testklasse erbt von unittest.TestCase
class TestAb4(unittest.TestCase):
	strInput    = "Hello world!"
	strReversed = "!dlrow olleH"

	def setUp(self):
		methodImplemented = True

		try:
			rev
			# Zugriff auf rev wirft einen NameError, wenn rev nicht vorhanden ist
			# Bei Instanzmethoden wird dies zu einem AttributeError
		except (NameError, AttributeError):
			# Wenn self.fail innerhalb des except-Blocks ist, kommt der NameError im StackTrace vor
			methodImplemented = False

		if not methodImplemented:
			self.fail("Die Lösung kann nicht getestet werden. \"def rev(str):\" fehlt!")


	# Alle Tests fangen mit "test_" an
	def test_rev_length(self):
		self.assertEqual(
			len(TestAb4.strInput), 
			len(rev(TestAb4.strInput)),
			"Die Länge deiner Lösung ist falsch!")

	def test_rev_reverses(self):
		self.assertEqual(
			TestAb4.strReversed,
			rev(TestAb4.strInput))

	def test_reverse_rev_for_original(self):
		self.assertEqual(
			TestAb4.strInput,
			rev(rev(TestAb4.strInput)))

# Wenn dies die Hauptdatei ist, führe den Testframework aus
if __name__ == '__main__':
	unittest.main()