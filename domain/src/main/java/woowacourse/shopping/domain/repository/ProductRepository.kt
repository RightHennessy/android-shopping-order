package woowacourse.shopping.domain.repository

import woowacourse.shopping.domain.Products

interface ProductRepository {
    fun getProducts(startIndex: Int, size: Int, onSuccess: (Products) -> Unit, onFailure: () -> Unit)
}
