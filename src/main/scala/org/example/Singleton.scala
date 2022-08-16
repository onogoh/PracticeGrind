package org.example

object Singleton {
  trait Currency {
    def getConversionRateToIndianRupee: String
  }

  object CurrencyConverter {
    private object EuroToRupee extends Currency {
      override def getConversionRateToIndianRupee = "82"
    }

    private object DollarToRupee extends Currency {
      override def getConversionRateToIndianRupee = "60"
    }

    private object NoIdea extends Currency {
      override def getConversionRateToIndianRupee = "No Idea"
    }

    // the currency factory method
    // Note: Scala if statement is an expression.
    def apply(s: String):Currency = {
      if (s == "Dollar")  // same as s.equals("Dollar") in Java
        DollarToRupee
      else if (s == "Euro")
        EuroToRupee
      else
        NoIdea
    }
  }

  val c = CurrencyConverter("Dollar") // apply method in action
  c.getConversionRateToIndianRupee  // outputs "60"

}
