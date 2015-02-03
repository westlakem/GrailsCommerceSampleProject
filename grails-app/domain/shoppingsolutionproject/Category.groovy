package shoppingsolutionproject

class Category {
	
	String name
	Category parentCategory

    static constraints = {
		name unique:true
		parentCategory nullable:true
    }
}
