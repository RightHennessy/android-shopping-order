package woowacourse.shopping.model.data.repository

import com.shopping.domain.Product
import com.shopping.repository.ProductRepository
import woowacourse.shopping.model.data.db.ProductService

class ProductRepositoryImpl(
    private val service: ProductService
) : ProductRepository {

    override fun loadProducts(
        index: Pair<Int, Int>,
        onSuccess: (List<Product>) -> Unit,
        onFailure: () -> Unit
    ) {
        Thread {
            service.request(
                onSuccess = { products ->
                    if (index.first >= products.size) {
                        onSuccess(emptyList())
                    }
                    onSuccess(products.subList(index.first, minOf(index.second, products.size)))
                },
                onFailure = onFailure
            )
        }.start()
    }

    override fun getProductById(
        index: Int,
        onSuccess: (Product) -> Unit,
        onFailure: () -> Unit
    ) {
        Thread {
            service.request(
                onSuccess = { products ->
                    onSuccess(products[index - 1])
                },
                onFailure = onFailure
            )
        }.start()
    }
}
