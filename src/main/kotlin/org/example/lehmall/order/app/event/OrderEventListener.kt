//package org.example.lehmall.order.app.event
//
//import org.example.lehmall.order.domain.event.OrderCreatedEvent
//import org.slf4j.LoggerFactory
//import org.springframework.context.event.EventListener
//import org.springframework.scheduling.annotation.Async
//import org.springframework.stereotype.Component
//import org.springframework.transaction.event.TransactionPhase
//import org.springframework.transaction.event.TransactionalEventListener
//
//@Component
//class OrderEventListener {
//
//    private val logger = LoggerFactory.getLogger(javaClass)
//
//    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
//    @Async
//    fun handleOrderCreatedEvent(event: OrderCreatedEvent) {
//        logger.info(
//            "Order created event received - OrderId: {}, OrderNo: {}, MemberId: {}, TotalAmount: {}, ItemCount: {}",
//            event.orderId, event.orderNo, event.memberId, event.totalAmount, event.itemCount
//        )
//
//        // 여기에 주문 생성 후 처리 로직 구현
//        // 예: 알림 발송, 재고 차감, 포인트 적립 등
//    }
//
//    @EventListener
//    fun handleOrderCreatedEventSync(event: OrderCreatedEvent) {
//        logger.info(
//            "Order created event received (sync) - OrderNo: {}, OccurredAt: {}",
//            event.orderNo, event.occurredAt
//        )
//
//        // 동기적으로 처리해야 할 로직이 있다면 여기에 구현
//    }
//}
