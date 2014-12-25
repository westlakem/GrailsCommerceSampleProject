package shoppingsolutionproject

class Category {
	
	String description

    static constraints = {
		description unique:true
    }
	
	@Override
	String toString() {
		return description
	}
}
