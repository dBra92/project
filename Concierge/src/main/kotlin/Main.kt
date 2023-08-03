fun main(args: Array<String>) {
    concierge()
}

fun concierge() {

    var typeInvite: String?

    class Invite constructor(typeInvite: String)

    print("What's type your invite:")
    typeInvite = readLine()

    if (typeInvite != null && typeInvite != "") {
        typeInvite = typeInvite.lowercase()

        if (typeInvite != "comum" && typeInvite != "premium" && typeInvite != "luxury") {
            println("Denied. Invalid invite")
            return
        }
    }

    print("What's your invite code:")
    var codeInvite=  readLine()

    if (codeInvite != null && codeInvite != "") {
        codeInvite = codeInvite.lowercase()

        if (typeInvite == "comum" && typeInvite.startsWith("xt")) {
            println("Welcome ;)")
        } else if ((typeInvite == "premium" || typeInvite == "luxury") && codeInvite.startsWith("xl")) {
            println("Welcome pt 2")
        } else {
            println("Denied. Invalid invite")
        }

    }

    print("Whats your age:")
    val age= readLine()

    if (age != null && age != "") {
        println("Denied. Minors are not allowed")
        return
    }
}