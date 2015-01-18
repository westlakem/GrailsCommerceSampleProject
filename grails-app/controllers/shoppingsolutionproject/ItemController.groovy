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

/*class FileResourceController {
	
	def index = { redirect(action:list,params:params) }
	static transactional = true
	
	def allowedMethods = []

	def list = {
		def fileResourceInstanceList = []
		def f = new File( grailsApplication.config.images.location.toString() )
		if( f.exists() ){
			f.eachFile(){ file->
			if( !file.isDirectory() )
				fileResourceInstanceList.add( file.name )
			}
		}
		[ fileResourceInstanceList: fileResourceInstanceList ]
	}

	def delete = {
		def filename = params.id.replace('###', '.')
		def file = new File( grailsApplication.config.images.location.toString() + File.separatorChar +   filename )
		file.delete()
		flash.message = "file ${filename} removed"
		redirect( action:list )
	}

	def upload = {
		def f = request.getFile('fileUpload')
		if(!f.empty) {
		  flash.message = 'Your file has been uploaded'
		  new File( grailsApplication.config.images.location.toString() ).mkdirs()
		  f.transferTo( new File( grailsApplication.config.images.location.toString() + File.separatorChar + f.getOriginalFilename() ) )
		}
		else {
		   flash.message = 'file cannot be empty'
		}
		redirect( action:list)
	}*/
}
