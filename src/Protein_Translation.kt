/* translate RNA sequence into protein */

const val RNA = "AUGUUUUCUUAAAUG"

fun splitInThreeSequence(rna: String): List<String> {
    /* Use this function for separating sequence into codons that could be interpreted as protein */
    return rna.chunked(3)
}

fun convertCondonsInProtein(Codons:List<String>): List<String> {
    /* use a dictionary to assimilate codons sequence and protein based on the documentation */
    val list:MutableList<String> = mutableListOf()


    val tableOfProtein: MutableMap<String, String> = mutableMapOf(
        /* map to link codon and protein */
        "AUG" to "Methionine",
        "UUU" to "Phenylalanine" ,
        "UUC" to "Phenylalanine" ,
        "UUA" to "Leucine",
        "UUG" to "Leucine",
        "UCU" to "Serine",
        "UGC" to "Serine",
        "UCA" to "Serine",
        "UCG" to "Serine",
        "UAU" to "Tyrosine",
        "UAC" to "Tyrosine",
        "UGU" to "Cysteine",
        "UGC" to "Cysteine",
        "UGG" to "Tryptophan",
        "UAA" to "Stop",
        "UAG" to "Stop",
        "UGA" to "Stop"
    )

    for (codon in Codons) {
        /* iterate in the list to assimilate each codon to protein */
        if (tableOfProtein[codon]=="Stop") {
            println("End of the translation")
            break
        }
        tableOfProtein[codon]?.let { list.add(it) }

    }

    return list
}

fun main(args: Array<String>) {
    val condons = splitInThreeSequence(RNA)
    val protein = convertCondonsInProtein(condons)
    println(protein)
}