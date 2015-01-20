package shoppingsolutionproject

import javax.net.ssl.SSLEngineResult.Status;

class ItemController {
	
	private def FOLDERLOCATION = 'web-app/images/products/'

    def scaffold = Item
	
	def images(){
		def productImages = []
		def item = Item.findByProductNumber(params.productNumber)
		def folderLocation = "${FOLDERLOCATION}${item.productNumber}"
		def file = new File(folderLocation)
		if (!file.exists()){
			file.mkdirs()
		}
		file.eachFile(){ image->
			if(!image.isDirectory()){
				productImages.add(image.name)
			}
		}
		[productImages:productImages, folderLocation:folderLocation, item:item]
	}

	def removeImage(){
		def productNumber = params.productNumber
		def imageName = params.imageName
		def file = new File(FOLDERLOCATION+productNumber+'/'+imageName)
		file.delete()
		render(status: 200)
	}
	
	def updatePrimaryImage(){
		def item = Item.findByProductNumber(params.productNumber)
		item.primaryImage = params.imageName
		item.save(flush: true)
		render(status: 200)
	}
}
