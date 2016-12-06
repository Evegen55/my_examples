/**
 * @author Evgenii_Lartcev (created on 12/6/2016).
 */
println 'Hello from Groovy'

def name='Lartsev'

def prt(q) {
    if (q == 1) {
        println 'the if part'
    } else {
        println 'the else part'
    }
}

println "Hello $name!"

println 6.multiply(11).minus(2)

println 6.multiply(11.minus(2))

println (!false || true) && (false || true)

println  "Hello".size()

println (['H', 'e', 'l', 'l', 'o'].asBoolean())

println (['H', 'e', 'l', 'l', 'o'].reverse())

println (['H', 'e', 'l', 'l', 'o'].last())

println (['H', 'e', 'l', 'l', 'o'].tail())

println (['H', 'e', 'l', 'l', 'o'].head())

println "1 + 2 == ${1 + 2}"

prt(7)